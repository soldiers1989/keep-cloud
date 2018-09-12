package cn.qidd.keep.domain.util;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

/**
 * 管理HttpSession
 * 单例的HttpSession
 */
public class SessionStore {

    private Map<String, HttpSession> appUserSessions;

    private SessionStore() {
        appUserSessions = new HashMap<>();
    }

    private static class LazyHolder {
        private static final SessionStore INSTANCE = new SessionStore();
    }

    public static SessionStore getInstance() {
        return LazyHolder.INSTANCE;
    }

    public HttpSession getSession(String id) {
        return appUserSessions.get(id);
    }

    public void addUser(String id, HttpSession session) {
        appUserSessions.put(id, session);
    }

    public void removeUser(String id) {
        appUserSessions.remove(id);
    }
}
