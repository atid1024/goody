package goody.domain;

import goody.domain.*;
import goody.infra.AbstractEvent;
import lombok.*;
import java.util.*;
@Data
@ToString
public class FileDeleted extends AbstractEvent {

    private Long id;
}


