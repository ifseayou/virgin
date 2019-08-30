package com.isea.virgin.avro;

import org.apache.avro.file.DataFileReader;
import org.apache.avro.file.DataFileWriter;
import org.apache.avro.io.DatumReader;
import org.apache.avro.io.DatumWriter;
import org.apache.avro.specific.SpecificDatumReader;
import org.apache.avro.specific.SpecificDatumWriter;

import java.io.File;
import java.io.IOException;

/**
 * @author isea_you
 * @date 2019/8/30
 * @time 11:23
 * @target:
 */
public class Test {
    public static void main(String[] args) throws IOException {
        User.Builder builder = User.newBuilder();
        builder.setName("张三");
        builder.setAge(30);
        builder.setEmail("zhangsan@*.com");
        User user = builder.build();

        //序列化
        File diskFile = new File("g:/data/users.avro");
        DatumWriter<User> userDatumWriter = new SpecificDatumWriter<User>(User.class);
        DataFileWriter<User> dataFileWriter = new DataFileWriter<User>(userDatumWriter);
        //指定schema
        dataFileWriter.create(User.getClassSchema(), diskFile);
        dataFileWriter.append(user);
        dataFileWriter.fSync();//多次写入之后，可以调用fsync将数据同步写入磁盘(IO)通道
        user.setName("李四");
        user.setEmail("lisi@*.com");
        dataFileWriter.append(user);
        dataFileWriter.close();

        //反序列化
        DatumReader<User> userDatumReader = new SpecificDatumReader<User>(User.class);
        // 也可以使用DataFileStream
        // DataFileStream<User> dataFileStream = new DataFileStream<User>(new FileInputStream(diskFile),userDatumReader);
        DataFileReader<User> dataFileReader = new DataFileReader<User>(diskFile, userDatumReader);
        User _current = null;
        while (dataFileReader.hasNext()) {

            //注意:avro为了提升性能，_current对象只会被创建一次，且每次遍历都会重用此对象
            //next方法只是给_current对象的各个属性赋值，而不是重新new。
            _current = dataFileReader.next(_current);
            //toString方法被重写，将获得JSON格式
            System.out.println(_current);
        }
        dataFileReader.close();
    }
}
