public class Tick {

    public void startTick(){
        final Runnable tickRunner = new Runnable() {
            public void run() {
                Tamgotchi.tick();
            }
        }
    }
}
