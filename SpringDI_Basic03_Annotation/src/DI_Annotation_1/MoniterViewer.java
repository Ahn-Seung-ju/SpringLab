package DI_Annotation_1;



import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import DI_Annotation_01.Recorder;

public class MoniterViewer {
	private Recorder recorder;

	public Recorder getRecorder() {
		return recorder;
	}
	
	
		@Resource
		public void setRecorder(Recorder recorder) {
			this.recorder = recorder;
		}
		
		public void Gmethod(Recorder rec) {
			System.out.println("Gmethod(rec): " + rec);
		}
	
	
	
}
