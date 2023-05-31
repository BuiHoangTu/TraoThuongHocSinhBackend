package bhtu.work.tths.models.enums;

public enum EGetStudents {
    ID(1),
    NAME(2),
    SCHOOL(3),
    CLASS(4),
    PARENT(5)
    
    ;//--------------------------------------------
    public final int intVal;

    private EGetStudents(int intVal) {
        this.intVal = intVal;
    }
}
