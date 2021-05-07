package DI_Annotation_01;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class MoniterViewer {
	private Recorder recorder;

	public Recorder getRecorder() {
		return recorder;
	}
	
	
	
	@Autowired
	public void setRecorder(Recorder recorder) {
		this.recorder = recorder;
	}
	
	
}
