package com.zhuhaoman.bytebuddy.buddy;

import com.zhuhaoman.bytebuddy.dto.Bar;
import com.zhuhaoman.bytebuddy.dto.Foo;
import net.bytebuddy.ByteBuddy;
import net.bytebuddy.agent.ByteBuddyAgent;
import net.bytebuddy.dynamic.loading.ClassReloadingStrategy;
import org.junit.Test;

/**
 * @ClassName ByteTest
 * @Description TODO
 * @Author zhuhaoman
 * @Date 2019/9/4 14:55
 **/
public class ByteTest {
    @Test
    public void test1() {
        ByteBuddyAgent.install();
        Foo foo = new Foo();
        new ByteBuddy()
                .redefine(Bar.class)
                .name(Foo.class.getName())
                .make()
                .load(Foo.class.getClassLoader(), ClassReloadingStrategy.fromInstalledAgent());

    }
}
