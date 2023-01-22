import java.awt.Graphics;

public class <class_name> implements Runnable {

	private Thread gameThread;
	private final int FPS_SET = 120;
	private final int UPS_SET = 120;

	public <class_name>() {

		startGameThread();

	}

	private void startGameThread() {
		gameThread = new Thread(this);
		gameThread.start();
	}

	@Override
	public void run() {

		double timePerFrame = 1000000000.0 / FPS_SET;
		double timePerUpdate = 1000000000.0 / UPS_SET;

		long previousFrame = System.nanoTime();

		int frames = 0;
		int update = 0;
		long lastCheck = System.currentTimeMillis();

		double deltaU = 0;
		double deltaF = 0;

		while (gameThread != null) {

			long currentTime = System.nanoTime();
			
			deltaU += (currentTime - previousTime) / timePerUpdate;
			deltaF += (currentTime - previousTime) / timePerFrame;
			previousTime = currentTime;
			
			if (deltaU >= 1) {
				//update();
				updates++;
				deltaU--;
			}
			
			if (deltaF >= 1) {
				//repaint();
				frames++;
				deltaF--;
			}

			if (System.currentTimeMillis() - lastCheck >= 1000) {
				lastCheck = System.currentTimeMillis();
				System.out.println("FPS: " + frames + " | UPS: " + updates);
				frames = 0;
				updates = 0;
			}
		}

	}

}
