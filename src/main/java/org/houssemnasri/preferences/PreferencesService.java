package org.houssemnasri.preferences;

import java.nio.file.Path;
import java.util.Map;

public interface PreferencesService {
    int getMinRange();

    int getMaxRange();

    void setMinRange(int min);

    void setMaxRange(int max);

    Map<String, Object> getDefaultsMapping();

    Path getPreferencesNodePath();
}
