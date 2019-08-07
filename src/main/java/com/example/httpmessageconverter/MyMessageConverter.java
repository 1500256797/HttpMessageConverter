package com.example.httpmessageconverter;

import org.springframework.http.HttpInputMessage;
import org.springframework.http.HttpOutputMessage;
import org.springframework.http.MediaType;
import org.springframework.http.converter.AbstractHttpMessageConverter;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.http.converter.HttpMessageNotWritableException;
import org.springframework.util.StreamUtils;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;

/**
 * ClassName: MyMessageConverter
 * Description: TODO
 * Author : Administrator
 * Date : 2019/8/7 17:10
 * Version : 1.0
 **/
public class MyMessageConverter extends AbstractHttpMessageConverter<User> {
    public MyMessageConverter() {
        //声明一种自定义的数据类型
        super(new MediaType("application", "x-x", Charset.forName("UTF-8")));
    }

    @Override
    protected boolean supports(Class<?> aClass) {
        // 表明本HttpMessageConverter 只能用来处理User 这个类。
        return User.class.isAssignableFrom(aClass);
    }

    //  /**
    //     * 重写readlntenal 方法，处理请求的数据。代码表明我们处理由“-”隔开的数据，并转成 user 的对象。
    //     */
    @Override
    protected User readInternal(Class<? extends User> aClass, HttpInputMessage httpInputMessage) throws IOException, HttpMessageNotReadableException {
        String temp  = StreamUtils.copyToString(httpInputMessage.getBody(),Charset.forName("UTF-8"));
        String[] temp2 = temp.split("-");
        return new  User(temp2[0],temp2[1],Integer.valueOf(temp2[2]));
    }

    /*
     * @Author Zhangzhenqian
     * @Description //处理如何把user对象，以"-"分割的形式输出
     * @Date 17:28 2019/8/7
     * @Param [user, httpOutputMessage]
     * @return void
     **/
    @Override
    protected void writeInternal(User user, HttpOutputMessage httpOutputMessage) throws IOException, HttpMessageNotWritableException {
        String temp = user.getName()+"-"+user.getSex()+"-"+user.getAge();
        httpOutputMessage.getBody().write(temp.getBytes());
    }
}
