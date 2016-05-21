package renderEngine;
import org.lwjgl.LWJGLException;
import org.lwjgl.Sys;
import org.lwjgl.opengl.*;

public class DisplayManager {
	private static final int WIDTH = 1280;
	private static final int HEIGHT = 720;
	private static final int FPS_CAP = 120;
        private static long LastFrameTime;
        private static int delta ; 
        
        
	public static void createDisplay()
	{
		
		ContextAttribs attribs = new ContextAttribs(3,2).withForwardCompatible(true).withProfileCore(true);
		try {
			Display.setDisplayMode(new DisplayMode(WIDTH,HEIGHT));
			Display.create(new PixelFormat(),attribs);
			Display.setTitle("3D GAME");
		} catch (LWJGLException e) {
			e.printStackTrace();
		}
		GL11.glViewport(0, 0, WIDTH, HEIGHT);
                LastFrameTime = getCurrentTime();

        }
	public static void updateDisplay()
	{
		Display.sync(FPS_CAP);
		Display.update();
                long CurrentFrameTime = getCurrentTime();
                delta = (int) ((CurrentFrameTime - LastFrameTime)/1000f);
	        LastFrameTime =CurrentFrameTime ;
        }
        
        public static float getFrameTimeSeconds(){
        return delta;
        }
	public static void closeDisplay()
	{
		Display.destroy();
       
	}
        public static long getCurrentTime(){
        
        return Sys.getTime()*1000/Sys.getTimerResolution();
        }
        
}
