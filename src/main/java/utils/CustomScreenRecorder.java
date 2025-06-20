package utils;

import org.monte.media.Format;
import org.monte.screenrecorder.ScreenRecorder;

import java.awt.*;
import java.io.File;
import java.io.IOException;

public class CustomScreenRecorder extends ScreenRecorder {
    private final String name;

    public CustomScreenRecorder(GraphicsConfiguration cfg, Rectangle captureArea,
                                Format fileFormat, Format screenFormat,
                                Format mouseFormat, Format audioFormat,
                                File movieFolder, String name) throws IOException, AWTException {
        super(cfg, captureArea, fileFormat, screenFormat, mouseFormat, audioFormat, movieFolder);
        this.name = name;
    }

    @Override
    protected File createMovieFile(Format fileFormat) throws IOException {
        return new File(movieFolder, name + ".avi");
    }
}

