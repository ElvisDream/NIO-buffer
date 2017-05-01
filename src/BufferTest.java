import java.nio.CharBuffer;

/**
 * buffer的主要作用就是装入数据，然后输出数据，开始时buffer的capacity为0，limit为capacity
 * 每放入一个数据，buffer的position相应地向后移动一个位置
 * 当buffer装入数据后，调用buffer的flip方法，将limit设置为position所在位置，并将position设置为0
 * 这就使得buffer的读写指针又移到了开始的位置
 * 注意：clear方法不是清楚数据，仅仅是将position置为0，将limit置为capacity，为再次向buffer中装入数据做准备
 */
public class BufferTest {

    public static void main(String[] args) {

        //       1.创建Buffer,容量设置为8
        CharBuffer buffer = CharBuffer.allocate(8);

        System.out.println("capacity: " + buffer.capacity());

        System.out.println("limit: " + buffer.limit());

        System.out.println("position :" + buffer.position());

        //        2.放入元素
        buffer.put('a');
        buffer.put('b');
        buffer.put('c');

        System.out.println("加入元素后，position = " + buffer.position());

        //        3.调用flip()方法
        buffer.flip();

        System.out.println("执行flip()后，limit= " + buffer.limit());
        System.out.println("position= " + buffer.position());

        //        4.取出第一个元素
        System.out.println("第一个元素（position=0）:" + buffer.get());
        System.out.println("取出第一个元素后，position = " + buffer.position());

        //        5.调用clear()方法
        buffer.clear();
        System.out.println("执行clear()后，limit= " + buffer.limit());
        System.out.println("position= " + buffer.position());

        //        6
        System.out.println("执行clear()方法后，缓冲区内容并没有被清除：" + "第三个元素为：" + buffer.get(2));
        System.out.println("执行绝对读取后，position=" + buffer.position());
    }
}
