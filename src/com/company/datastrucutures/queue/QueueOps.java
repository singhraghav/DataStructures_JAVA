package com.company.datastrucutures.queue;

import java.util.Queue;

public class QueueOps {
    public static Queue<Integer> reverse(Queue<Integer> queue){
        if(queue.isEmpty())
            return queue;
        Integer front = queue.remove();
        Queue<Integer> partial = reverse(queue);
        partial.add(front);
        return partial;
    }
}
