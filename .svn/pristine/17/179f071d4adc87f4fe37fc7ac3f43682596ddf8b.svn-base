package com.wjmShop.utils;

import java.io.PrintWriter;
import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Map;
import java.util.Properties;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.util.ValueStack;

/**
 *
 */
public class BaseAction extends ActionSupport implements SessionAware, ServletRequestAware {
    private static final long serialVersionUID = -6553647142521174086L;

    protected int page = 1;
    protected String pageTool;

    protected Map<String, Object> session;
    
    protected HttpServletRequest servletRequest;

    // 版本信息
    protected String versionProperties = "version.properties";
    // message信息
    protected String messageProperties = "message.properties";
    // 邮件信息
    protected String mailProperties = "mail.properties";

    @Override
    public void setSession(Map<String, Object> session) {
        this.session = session;
    }

    public Map<String, Object> getSession() {
        return session;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public String getPageTool() {
        return pageTool;
    }

    public void setPageTool(String pageTool) {
        this.pageTool = pageTool;
    }

    @Override
    public void setServletRequest(HttpServletRequest servletRequest) {
        this.servletRequest = servletRequest;
    }

    /**
     * レスポンス
     *
     * @param msg
     */
    protected void sendResponseMsg(String msg) {
        HttpServletResponse response = ServletActionContext.getResponse();
        response.setContentType("text/html");
        response.setHeader("Pragma", "no-cache");
        response.setHeader("Cache-Control", "no-store");
        response.addHeader("Cache-Control", "must-revalidate");
        response.addHeader("Cache-Control", "post-check=0, pre-check=0");
        response.setDateHeader("Expires", 0);
        response.setCharacterEncoding("UTF-8");
        PrintWriter out = null;
        try {
            out = response.getWriter();
            out.print(msg);
        } catch (Throwable e) {
            e.printStackTrace();
        } finally {
            out.close();
        }
    }

    /**
     * エラーメッセージ
     *
     * @throws Exception
     */
    protected void setMessages() throws Exception {
        // Applicationプロパティ読込む
        Properties properties = new Properties();
        properties.load(Thread.currentThread().getContextClassLoader().getResourceAsStream(messageProperties));

        // 有効期間切れ
        session.put("overdueMsg", properties.getProperty("overdueMsg"));
        // 登録済データ
        session.put("existMsg", properties.getProperty("existMsg"));
        // 配車情報取得エラー
        session.put("haishaErrorMsg", properties.getProperty("haishaErrorMsg"));
        // コンテナが未入力エラー
        session.put("containerErrorMsg", properties.getProperty("containerErrorMsg"));
    }

    /**
     * バージョン情報
     *
     * @throws Exception
     */
    protected void setVersion() throws Exception {
        // バージョン
        Properties properties = new Properties();
        properties.load(Thread.currentThread().getContextClassLoader().getResourceAsStream(versionProperties));

        String major = properties.getProperty("major");
        String minor = properties.getProperty("minor");
        String build = properties.getProperty("build");
        String revision = properties.getProperty("revision");

        session.put("version", String.format("Version: %s.%s.%s", major, minor, build));
    }

    /**
     * 和暦変換
     *
     * @throws Exception
     */
    protected String getWareki(Date seireki) {
        Locale locale = new Locale("ja", "JP", "JP");
        DateFormat japaneseFormat = DateFormat.getDateInstance(DateFormat.FULL, locale);
        return japaneseFormat.format(seireki);
    }

    /**
     * 放送メッセージ
     *
     * @return NULL
     * @throws Exception
     */
    protected void sendMsgToClient(String result) throws Exception {
        HttpServletResponse response = ServletActionContext.getResponse();
        response.setCharacterEncoding("UTF-8");
        response.getWriter().write(result);
    }
}