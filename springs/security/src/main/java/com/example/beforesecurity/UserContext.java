package com.example.beforesecurity;

public class UserContext {
    //초기화
    //이렇게 람다식으로 초기화가 가능
    //근데 일단은 넣을게 없으니 빙누다
    private static final ThreadLocal<User> userThreadLocal
            = ThreadLocal.withInitial(() ->null);
    //스레드 로컬에 유저 객체 넣기
    public static void setUser(User user) {
        userThreadLocal.set(user);
    }

    //스레드 로컬에 유저 객체 꺼내주기
    public static User getUSer() {
        return userThreadLocal.get();
    }
    //스레드 로컬에 있는 객체를 삭제
    public static void clear() {
        userThreadLocal.remove();
    }
}
