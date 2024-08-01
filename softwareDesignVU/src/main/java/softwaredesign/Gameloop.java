package softwaredesign;

import java.util.Scanner;
import java.time.Duration;
import java.util.concurrent.Executors;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.*;

public class Gameloop implements Runnable {

    Display display = new Display();
    //private boolean running;
    private final double updateRate = 1.0d/60.0d;
    private long nextStatTime;
    private int fps, ups, iterr;

    @Override
    public void run() {
        //running = true;
        double accumulator = 0;
        long currentTime, lastUpdate = System.currentTimeMillis();
        nextStatTime = System.currentTimeMillis() + 1000;

        display.welcomeScreen();
        Bodybuilder bodybuilder = BodyBuilderFactory.create();
        display.enterDetails(bodybuilder);

        while(bodybuilder.alive) {

            iterr++;

            currentTime = System.currentTimeMillis();
            double lastRenderTimeInSeconds = (currentTime - lastUpdate) / 1000d;
            accumulator += lastRenderTimeInSeconds;
            lastUpdate = currentTime;

            while(accumulator > updateRate) {
                update();
                accumulator -= updateRate;
            }
            render();

            if(System.currentTimeMillis() > nextStatTime) { // vsichko na screena e tuk
                display.printInfo(bodybuilder);
                display.printBodybuilder(bodybuilder);
                display.printBars(bodybuilder);
                display.printStats(fps, ups, iterr);
                //Boolean exitLoop = false;
                //System.out.print("Command: ");
                //String input = inputDelay();
                final Duration timeout = Duration.ofSeconds(3);
                ExecutorService executor = Executors.newSingleThreadExecutor();
                Scanner scan = new Scanner(System.in);

                final Future<String> handler = executor.submit(new Callable<String>() {
                    @Override
                    public String call() throws Exception {
                        return scan.nextLine();
                    }
                });
                try {
                    String input = handler.get(timeout.toMillis(), TimeUnit.MILLISECONDS);
                    bodybuilder.commandExecute(input);
                    //System.out.print("User input: " + input);
                } catch (TimeoutException e) {
                    //handler.cancel(true);
                    System.out.println("");
                    System.err.println("TOO SLOW FOR ME! TRY FASTER! YOU WILL LOSE!");
                } catch (InterruptedException e) {
                    //System.err.println("Input was interrupted: " + e.getMessage());
                } catch (ExecutionException e) {
                    System.err.println("An error occurred while reading input: " + e.getMessage());
                }
                executor.shutdown();




                //Scanner scan = new Scanner(System.in);
                //String inputCommand = scan.next();
                //bodybuilder.commandExecute(inputCommand);

                // tuk statove
                //__________
                //| Hunger  |
                //|  78/100 |
                //__________
                bodybuilder.decreaseStats();
                nextStatTime = System.currentTimeMillis() + 1000;
            }
        }
    }


    private void render() {
        fps++;
    }

    private void update() {
        ups++;
    }

}
