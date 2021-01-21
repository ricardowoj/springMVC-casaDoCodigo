<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Cadastro de produtos</title>
</head>
<body>
	<form method="post" action="/casadocodigo/produtos">
		<div>
			<label for="title">Titulo</label>
			<input id="title" name="title" type="text"/>
		</div>
		<div>
			<label for="description">Descrição</label>
			<textarea rows="10" cols="20" name="description" id="description"></textarea>
		</div>
		<div>
			<label for="pages">Número de páginas</label>
			<input id="pages" name="pages" type="text"/>
		</div>
		<div>
			<input type="submit" value="Enviar" id="button-1"/>
		</div>
	</form>
</body>
</html>