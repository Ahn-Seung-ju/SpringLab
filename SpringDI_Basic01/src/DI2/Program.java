package DI2;

public class Program {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		NewRecordView view = new NewRecordView();
		
		NewRecord record = new NewRecord(100, 80, 88);
		
		view.setRecord(record);
		
		view.print();
		
	}

}
