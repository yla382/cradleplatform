package Model;

import java.io.IOException;
import java.util.*;

/**
 * Created by John on 8/1/2016.
 * Class that manages the datas for UIs to use
 * Contains lists of UIObservsers to set the sequence
 * of instruction to run when the program is
 * running.
 */
public class Model implements Comparator<CourseOrganizeAgain> {
    private List<UIObserver> observers = new ArrayList<>();
    private List<UIObserver> observersNext = new ArrayList<>();
    private List<UIObserver> observersNextNext = new ArrayList<>();
    private CourseDataBase base = new CourseDataBase();
    private Vector<String> options = getSubjects();
    private List<CourseData> list = new ArrayList<>();
    private List<CourseOrganized> organizedList = new ArrayList<>();
    private List<CourseOrganizeAgain> organizeAgainsList = new ArrayList<>();
    private CourseOrganizeAgain selectedCourse;
    private CourseOrganized selectedCourseDetail;

    public Model() throws IOException {
    }

    public void setDepartment(String string) {
        list.clear();
        organizedList.clear();
        organizeAgainsList.clear();
        for(CourseData data: base.getCourseDataList()) {
            if(data.getSubject().equals(string)) {
                list.add(data);
            }
        }
    }

    public List<CourseOrganizeAgain> getOrganizeAgainList() {
        return organizeAgainsList;
    }

    public void setOrganizeAgainList() {
        setCourseOrganized();
        for(CourseOrganized organized: organizedList) {
            int control = 0;
            if(organizeAgainsList.size() == 0) {
                organizeAgainsList.add(new CourseOrganizeAgain(organized));
            } else {
                for(CourseOrganizeAgain again: organizeAgainsList) {
                    if(again.isCorrectOrganized(organized)) {
                        again.addCourseOrganized(organized);
                        control++;
                    }
                }

                if(control == 0) {
                    organizeAgainsList.add(new CourseOrganizeAgain(organized));
                }
            }
        }

        java.util.Collections.sort(organizeAgainsList, this);
        notifyObservers();
    }

    int getStringValue(String str) {
        return Integer.valueOf("0" + str.replaceAll("(\\d*).*", "$1"));
    }

    @Override
    public int compare(CourseOrganizeAgain o1, CourseOrganizeAgain o2) {
        return getStringValue(o1.getCataloguNumber()) - getStringValue(o2.getCataloguNumber());
    }

    public List<CourseOrganized> getOrganizedList() {
        return organizedList;
    }


    public void setCourseOrganized() {
        for(CourseData data: list) {
            int control = 0;
            if(organizedList.size() == 0) {
                organizedList.add(new CourseOrganized(data));
            } else {
                for(CourseOrganized organized: organizedList) {
                    if(organized.isCorrectCourse(data)) {
                        organized.addCourseData(data);
                        control++;
                    }
                }

                if(control == 0) {
                    organizedList.add(new CourseOrganized(data));
                }
            }
        }

        for(CourseOrganized organized: organizedList) {
            organized.setComponentCodes();
        }
    }

    public Vector<String> getOptions() {
        return options;
    }

    public Vector<String> getSubjects() {
        Vector<String> subjects = new Vector<String>();

        for(CourseData data: base.getCourseDataList()) {
            if(!subjects.contains(data.getSubject())) {
                subjects.add(data.getSubject());
            }
        }
        Collections.sort(subjects);

        return subjects;
    }

    public void setGradAndUnderGrad(Boolean isUndergrad, Boolean isGrad) {
        List<CourseData> filtered = new ArrayList<>();
        if(isUndergrad && isGrad) {

        } else if (isUndergrad && !isGrad) {
            for(CourseData data: list) {
                if(getStringValue(data.getCatalogNumber()) < 500) {
                    filtered.add(data);
                }
            }

            list = filtered;
        } else if(!isUndergrad && isGrad) {
            for(CourseData data: list) {
                if(getStringValue(data.getCatalogNumber()) >= 500) {
                    filtered.add(data);
                }
            }

            list = filtered;
        } else {
            list.clear();
        }
    }

    public void setSelectedCourse(int index) {
        if(organizeAgainsList == null) {

        } else {
            selectedCourse = organizeAgainsList.get(index);
        }
    }

    public CourseOrganizeAgain getSelectedCourse() {
        return selectedCourse;
    }

    public void setSelectedCourseDetail(CourseOrganized organized) {
        selectedCourseDetail = organized;
    }

    public CourseOrganized getSelectedCourseDetail() {
        return selectedCourseDetail;
    }

    public void addObserver(UIObserver observer) {
        observers.add(observer);
    }


    public void notifyObservers() {
        for(UIObserver observer: observers) {
            observer.stateChanged();
        }
    }

    public void addObserverAgain(UIObserver observer) {
        observersNext.add(observer);
    }

    public void notifyObserversAgain() {
        for(UIObserver observer: observersNext) {
            observer.stateChanged();
        }
    }

    public void addObserversAgainAgain(UIObserver observer) {
        observersNextNext.add(observer);
    }

    public void notifyObserversAgainAgain() {
        for(UIObserver observer: observersNextNext) {
            observer.stateChanged();
        }
    }
}
