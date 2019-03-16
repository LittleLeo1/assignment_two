package classes;

import javax.xml.soap.Text;
import java.util.regex.Pattern;

public class post {
    private String title;
    private String body;
    private String setting;
    private String date;
    private String user;
    public void setTitle(String title)
    {
        this.title =title;
    }
    public void setBody(String body)
    {
        this.body=body;
    }
    public void setSetting(String setting) {
        this.setting = setting;
    }
    public void setDate(String date)
    {
        this.date = date;
    }
    public String getTitle()
    {
        return title;
    }
    public String getBody()
    {
        return body;
    }
    public String getSetting()
    {
        return setting;
    }
    public String getDate()
    {
        return date;
    }
    public void setUser(String User)
    {
        this.user = User;
    }
    public String getUser()
    {
        return user;
    }
    public boolean gooodText(String someText)
    {
        boolean match =false;
        String regPattern ="[A-Zaz0-9]";
        match = Pattern.matches(regPattern, someText);
        return match;
    }
    public boolean goodDate(){
        boolean match =false;
        String regPattern = "([12]\\d{3}-(0[1-9]|1[0-2])-(0[1-9]|[12]\\d|3[01]))";
        match = Pattern.matches(regPattern,date);
        return match;
    }
    public boolean goodPost(){
        boolean isGood=false;
        if ( gooodText(title)& gooodText(body) & gooodText(user)&goodDate())
        {
            isGood=true;
        }
        return isGood;

    }

}
