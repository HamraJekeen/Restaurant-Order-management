package queuepackage;

public class QueueNode {
	Order order;  
    QueueNode next;

    public QueueNode(Order order) {
        this.order = order;
        this.next = null;
    }

}
