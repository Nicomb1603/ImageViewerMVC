package view;



public interface ImageDisplay<T> {
    //void show(T image);
    void paintImage(T image, int x);

    void onReleased(Offset offset);

    void onDragged(Offset offset);

    public interface Offset {
        static void Null(int offset) {}
        void handle(int offset);
    }
    public void clear();

    public int width();
    public int height();

    public void setX(int x);
}
