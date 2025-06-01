<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8" />
<meta name="viewport" content="width=device-width, initial-scale=1" />
<title>Compose - Intranet Mailing System</title>
<style>
 body {
    font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
    margin: 0;
    background-color: #e6f0ff;
    color: #222;
    background-image: url(multi.jpg);
  }
  header {
    background-color: #4a90e2;
    color: white;
    padding: 1.5rem 2rem;
    text-align: center;
    box-shadow: 0 3px 6px rgba(0,0,0,0.12);
    font-family: Trebuchet MS;
  }
  nav {
    background-color: #2a66c7;
    padding: 0.6rem 2rem;
    display: flex;
    gap: 1rem;
  }
  nav a {
    color: white;
    text-decoration: none;
    font-weight: 600;
    padding: 0.45rem 1rem;
    border-radius: 4px;
    transition: background-color 0.3s;
  }
  nav a:hover, nav a.active {
    background-color: #194a9e;
  }
  main {
    max-width: 800px;
    margin: 1rem auto;
    background-color: white;
    padding: 2rem;
    border-radius :10px;
    box-shadow: 0 8px 20px rgba(0,0,0,0.1);
  }
  label {
    display: block;
    margin-bottom: 0.5rem;
    font-weight: bold;
    color: black;
  }
  input[type="text"], input[type="email"], textarea {
    width: 96%;
    padding: 0.6rem 0.8rem;
    margin-bottom: 1.2rem;
    border-radius: 4px;
    border: 1.8px solid #999999;
    font-size: 1rem;
    transition: border-color 0.3s;
  }
  input:focus, textarea:focus {
    outline: none;
    border-color: #48c6ef;
  }
  textarea {
    min-height: 150px;
    resize: vertical;
  }
  button {
    background-color: #0099ff;
    color: white;
    border: none;
    padding: 0.8rem 2rem;
    border-radius: 4px;
    font-size: 1.1rem;
    cursor: pointer;
    transition: background-color 0.3s;
    margin-right: 0.5rem;
  }
  button:hover {
    background-color: #2a9df4;
  }
   footer {
    text-align: center;
    padding: 1rem;
    font-size: 0.8rem;
    color: white;
  }
</style>
</head>
<body>
  <header>
      <h1> Compose - Intranet Mailing System </h1>
  </header>
  <nav>
      <a class="nav-link" href="dashboard.jsp">Dashboard</a>
                <a class="nav-link active" href="compose.jsp">Compose</a>
                <a class="nav-link" href="inbox">Inbox</a>
                <a class="nav-link" href="sent">Sent</a>
                <a href="drafts" class="list-group-item list-group-item-action">Draft</a>
                <a href="login.jsp" style="margin-left:auto;">Logout</a>
  </nav>


  
  <main>
    <form class="compose-form" action="sendmail" method="POST">
                <div class="mb-4">
                    <label for="to"> To : </label>
                    <input type="text" 
                           class="form-control" 
                           name="recipient" 
                           placeholder="College ID" 
                           required>
                </div>
                
                <div class="mb-4">
                    <input type="text" 
                           class="form-control" 
                           name="subject" 
                           placeholder="Subject" 
                           required>
                </div>
                
                <div class="mb-4">
                    <textarea class="form-control" 
                              name="body" 
                              rows="12" 
                              placeholder="Message" 
                              required></textarea>
                </div>
                
                <div class="d-flex btn-group">
                    <button type="submit" class="btn btn-primary px-5 py-2">Send</button>
                     
                    <button type="button" class="nav-link active" href="error.jsp">Save Draft</button>
                </div>
            </form>
  </main>
  <footer>
    &copy; 2025 Intranet Mailing System
  </footer>
</body>
</html>
