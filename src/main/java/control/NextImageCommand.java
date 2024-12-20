package control;

import view.ImageDisplay;

public class NextImageCommand implements Command{
    ImageDisplay imageDisplay;

    public NextImageCommand(ImageDisplay imageDisplay){this.imageDisplay = imageDisplay;}

    @Override
    public void execute() {
        imageDisplay.show(imageDisplay.image().next());
    }
}
