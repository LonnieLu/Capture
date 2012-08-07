import com.lonnie.capture.CaptureService;


public class CaptureTest {

  public static void main(String[] xing) {
    
    CaptureService captureService = new CaptureService();
    System.out.println(captureService.getCaptureNews().size());
  }
}
