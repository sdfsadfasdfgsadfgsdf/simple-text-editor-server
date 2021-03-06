package de.seven.fate.texteditor.converter;

import de.seven.fate.texteditor.entity.TextFileEntity;
import de.seven.fate.texteditor.vo.TextFile;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.Validate;
import org.springframework.stereotype.Component;

import static de.seven.fate.texteditor.constants.Constants.MAY_NOT_BE_NULL;

@Component
public class TextFile2TextFileEntityConverter implements DefaultConverter<TextFile, TextFileEntity> {

    @Override
    public void update(TextFile source, TextFileEntity target) {
        Validate.notNull(source, MAY_NOT_BE_NULL, "source");
        Validate.notNull(target, MAY_NOT_BE_NULL, "target");

        target.setId(source.getId());
        target.setFileName(source.getFileName());
        target.setContent(source.getContent());
        target.setSize((long) StringUtils.trimToEmpty(source.getContent()).length());
    }

    @Override
    public TextFileEntity createInstance() {
        return new TextFileEntity();
    }
}
