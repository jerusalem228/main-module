package com.sagroup.elementservice.service.Implementation;


import com.sagroup.elementservice.Domain.Element;
import com.sagroup.elementservice.Dto.ElementDto;
import com.sagroup.elementservice.Mapper.ElementMapper;
import com.sagroup.elementservice.repository.ElementRepository;
import com.sagroup.elementservice.service.ElementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author ABDELBIF
 * @version 1.0
 * @created 6-Feb-2023 10:00:00 PM
 */
@Service
@Transactional
public class ElementServiceImpl implements ElementService {
    @Autowired
    private ElementMapper elementMapper;

    @Autowired
    private ElementRepository elementRepository;

    @Override
    public ElementDto addElement(ElementDto elementDto) {
        Element element = new Element();
        element.setElementType(elementDto.getElementType());
        element.setPrice(elementDto.getPrice());
        //Element element = elementMapper.elementFromElementDto(elementDto);
        elementRepository.save(element);
        return elementDto;
    }

    @Override
    public void removeElement(Long id) {
        elementRepository.deleteById(id);
    }

    @Override
    public ElementDto updateElement(Long id, ElementDto elementDto) {
        Element element = elementMapper.elementFromElementDto(elementDto);

        elementRepository.save(element);
        return elementDto;
    }

    @Override
    public ElementDto viewElement(Long id) {
        Element element = elementRepository.findById(id).get();
        return elementMapper.elementDtoFromElement(element);
    }
}
