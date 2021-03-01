package tabuSearch;

import java.util.List;
import java.util.Queue;

import org.apache.commons.collections4.IteratorUtils;
import org.apache.commons.collections4.queue.CircularFifoQueue;

public class TabuList {

	Queue<State> tabuList;
	TabuList(){
		tabuList = new CircularFifoQueue(Constants.TABLE_TENURE);

	}
	void add(State state){
		tabuList.add(state);
	}
	boolean contains(State state){
		return tabuList.contains(state);
	}
	List<State> getTabuList(){
		return  IteratorUtils.toList(tabuList.iterator());
	}
}
