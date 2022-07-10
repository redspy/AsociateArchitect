import com.sun.tools.javac.util.Assert;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class EncapsulateCollectionClient {
    public void client(){
        Person kent = new Person();
        Set s = new HashSet();
        s.add(new Course ("Smalltalk Programming", false));
        s.add(new Course ("Appreciating Single Malts", true));
        kent.setCourses(s);
        Assert.equals (2, kent.getCourses().size());
        Course refact = new Course ("Refactoring", true);
        kent.getCourses().add(refact);
        kent.getCourses().add(new Course ("Brutal Sarcasm", false));
        Assert.equals (4, kent.getCourses().size());
        kent.getCourses().remove(refact);
        Assert.equals (3, kent.getCourses().size());

        Iterator iter = Person.getCourses().iterator();
        int count = 0;
        while (iter.hasNext()) {
            Course each = (Course) iter.next();
            if (each.isAdvanced()) count ++;
        }
    }
}
