package com.learn.backend.rest.controller;


import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.learn.backend.rest.dao.KelurahanDao;
import com.learn.backend.rest.entity.Kelurahan;

@Controller
public class KelurahanApiController {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(KelurahanApiController.class);

	@Autowired
	private KelurahanDao kelurahanDao;

	@GetMapping(value="/api/kelurahan")
	@ResponseBody
	private List<Kelurahan> findAll(Pageable page){
		return kelurahanDao.findAll(page).getContent();
	}
	
	@GetMapping("/api/kelurahan/{id}")
	@ResponseBody
	public Kelurahan cariKelurahanById(@PathVariable(name = "id") Kelurahan k) {
		return k;
	}
	
	@PostMapping("/api/kelurahan")
	@ResponseStatus(HttpStatus.CREATED)
	public void simpan(@RequestBody @Valid Kelurahan k) {
		kelurahanDao.save(k);
	}
	
	@DeleteMapping("/api/kelurahan/{id}")
	@ResponseStatus(HttpStatus.OK)
	public void hapus(@PathVariable("id") Kelurahan k) {
		if(k != null) {
			kelurahanDao.delete(k);
		}
	}
	
	@PutMapping("/api/kelurahan/{id}")
	@ResponseStatus(HttpStatus.OK)
	public void update(@PathVariable("id") Integer id, @RequestBody @Valid Kelurahan input) {
		Kelurahan dariDatabase = kelurahanDao.findOne(id);
		if(dariDatabase == null) {
			LOGGER.warn("Kelurahan dengan id {} tidak ada di database", id);
			return;
		}
		
		BeanUtils.copyProperties(input, dariDatabase);
		dariDatabase.setId(id);
		kelurahanDao.save(dariDatabase);
	}
	
}
