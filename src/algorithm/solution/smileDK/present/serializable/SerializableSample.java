package algorithm.solution.smileDK.present.serializable;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class SerializableSample {
    public static void main(String[] args) {
        // 직렬화할 객체
        Customer customer = new Customer(1, "도형", "1234", 20);

        // 외부 파일명
        String fileName = "Customer1.ser";

        // 파일 스트림 객체 생성 (try with resource)
        try (
                FileOutputStream fos = new FileOutputStream(fileName);
                ObjectOutputStream oos = new ObjectOutputStream(fos);
        ) {
            // 직렬화 가능 객체를 바이트 스트림으로 변환하고 파일에 저장
            oos.writeObject(customer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
