<!DOCTYPE HTML>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Login</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" type="text/css" href="estilos/style.css" >
</head>
<body>
    <input type='checkbox' id='form-switch'>
    <form id='login-form' action="login" method='post'>
      <input type="text" name="email" placeholder="Email" required>
      <input type="password" name="senha" placeholder="Senha" required>
      <button type='submit'>Logar</button>
      <label for='form-switch'><span>Cadastrar</span></label>
    </form>
    <form id='register-form' action="usuario" method='post'>
      <input type="text" name="c_nome" placeholder="Nome" required>
      <input type="email" name="c_email" placeholder="Email" required>
      <input type="password" name="c_senha" placeholder="Senha" required>
      <button type='submit'>Cadastrar</button>
      <label for='form-switch'>Faça seu login</label>
    </form>
    
</body>
</html>