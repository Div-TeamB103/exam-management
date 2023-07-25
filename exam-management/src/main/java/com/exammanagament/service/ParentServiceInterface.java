package com.exammanagament.service;


public interface ParentServiceInterface {

    public List<ParentDto> getAllParent() ;
    public Optional<ParentDto> getParenyByEmail( String email) throws NullPointerException, NotFoundUserException;
    public ParentDto createParent(ParentDto parentDto) throws DublicateUserException;
    ParentDto updateParent(Long id) throws NotFoundUserException;
    ParentDto deleteParent(Long id) throws NotFoundUserException;

}