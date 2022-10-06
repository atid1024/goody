package goody.infra;
import goody.domain.*;

import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.RepresentationModelProcessor;
import org.springframework.stereotype.Component;
import org.springframework.hateoas.EntityModel;

@Component
public class FileHateoasProcessor implements RepresentationModelProcessor<EntityModel<File>>  {

    @Override
    public EntityModel<File> process(EntityModel<File> model) {
        model.add(Link.of(model.getRequiredLink("self").getHref() + "/deletefile").withRel("deletefile"));

        
        return model;
    }
    
}
