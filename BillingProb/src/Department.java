

public abstract class Department {

	//fields
	
	private StringQueue queue = new StringQueue();

	public abstract String getName();

	public void addMessage(String msg){
		queue.enqueue(msg);
	}

	public String nextMessage(){
		String s = "";
			try{
				 s = queue.dequeue();
			}catch( EmptyQueueException e){

			}
		return s;
	}

	public StringQueue getQueue() {
		return queue;
	}
	//implement
}
