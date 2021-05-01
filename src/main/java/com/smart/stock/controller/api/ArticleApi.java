package com.smart.stock.controller.api;

import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.smart.stock.dto.ArticleDTO;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

import static com.smart.stock.utils.Constants.APP_ROOT;

@Api(APP_ROOT + "/articles")
public interface ArticleApi {

	@PostMapping(value = APP_ROOT
			+ "/articles/create", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value = "Enregistrer un article.", notes = "Cette methode permet d'enregister ou modifier un article.", response = ArticleDTO.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Article a été trouver dans la BD."),
			@ApiResponse(code = 400, message = "Article n'est pas valide.") })
	ArticleDTO save(@RequestBody ArticleDTO dto);

	@GetMapping(value = APP_ROOT + "/articles/{idArticle}", produces = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value = "Rechercher un article par ID.", notes = "Cette methode permet de rechercher un article par ID.", response = ArticleDTO.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Article a été trouver dans la BD."),
			@ApiResponse(code = 404, message = "Article n'est pas trouvé dans la BD.") })
	ArticleDTO findById(@PathVariable("idArticle") Integer id);

	@GetMapping(value = APP_ROOT + "/articles/code/{codeArticle}", produces = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value = "Rechercher un article par CODE.", notes = "Cette methode permet de rechercher un article par CODE.", response = ArticleDTO.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Article a été trouver dans la BD."),
			@ApiResponse(code = 404, message = "Article n'est pas trouvé dans la BD.") })
	ArticleDTO finByCodeArticle(@PathVariable("codeArticle") String codeArticle);

	@GetMapping(value = APP_ROOT + "/articles/all", produces = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value = "Renvoi la liste des articles.", notes = "Cette methode permet de rechercher et renvoyer la liste des article qui existent dans la BD.", responseContainer = "List<ArticleDTO>")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "La liste des articles / une liste Vide.") })
	List<ArticleDTO> findAll();

	@DeleteMapping(value = APP_ROOT + "articles/delete/{idArticle}")
	@ApiOperation(value = "Supprimer un article.", notes = "Cette methode permet de supprimer un article par sont ID.")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Article a été supprimé."), })
	void delete(@PathVariable("idArticle") Integer id);

}
