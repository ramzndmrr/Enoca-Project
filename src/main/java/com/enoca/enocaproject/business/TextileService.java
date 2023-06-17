package com.enoca.enocaproject.business;

import com.enoca.enocaproject.core.mappers.ModelMapperService;
import com.enoca.enocaproject.model.textile.Textile;
import com.enoca.enocaproject.model.textile.TextileRequest;
import com.enoca.enocaproject.model.textile.TextileResponse;
import com.enoca.enocaproject.repository.TextileRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TextileService {
    private TextileRepository textileRepository;
    private ModelMapperService modelMapperService;

    public TextileService(TextileRepository textileRepository,ModelMapperService modelMapperService){
        this.textileRepository = textileRepository;
        this.modelMapperService = modelMapperService;
    }

    public List<TextileResponse> getAll(){
        List<Textile> textileList = textileRepository.findAll();
        List<TextileResponse> textileResponseList = textileList
                .stream()
                .map(textile -> this.modelMapperService.forResponse().map(textile,TextileResponse.class))
                .collect(Collectors.toList());
        return textileResponseList;
    }

    public TextileResponse save(TextileRequest textileRequest){
        Textile textile = this.modelMapperService.forRequest().map(textileRequest,Textile.class);
        Textile saveTextile = textileRepository.save(textile);
        TextileResponse textileResponse = this.modelMapperService.forResponse().map(saveTextile,TextileResponse.class);
        return textileResponse;
    }

    public TextileResponse update(TextileRequest textileRequest){
        Textile savedTextile = textileRepository.findById(textileRequest.getId()).orElseThrow();
        textileRepository.save(savedTextile);
        TextileResponse textileResponse=this.modelMapperService.forResponse().map(savedTextile,TextileResponse.class);
        return textileResponse;
    }

    public void deleteTextile(Long id){
        textileRepository.deleteById(id);
    }

}
