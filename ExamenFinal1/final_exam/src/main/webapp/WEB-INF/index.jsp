<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Examen Final</title>
</head>
<body>
    <h1>Bienvenidos TDB!</h1>

    <form action="" method="post">Registrarte
        <div>
            <label for="">Nombre:</label>
            <input type="text" name="nombre">
        </div>
        <div>
            <label for="">Email:</label>
            <input type="email" name="email">
        </div>
        <div>
            <label for="">Contraseña:</label>
            <input type="password" name="password">
        </div>
        <div>
            <label for="">Confirmación:</label>
            <input type="text" name="confirmation">
        </div>
        <div>
            <input type="submit" value="Registrarte">
        </div>
        

    </form>
</body>
</html>

