package random_path;


public class PathGeneratorController {
    private PathModel model;
    private RandomPathView view;

    public PathGeneratorController() {
        model = new PathModel();
        view = new RandomPathView(model);
    }
}
