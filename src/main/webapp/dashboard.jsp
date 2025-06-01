<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8" />
<meta name="viewport" content="width=device-width, initial-scale=1" />
<title>Dashboard - Intranet Mailing System</title>
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
    max-width: 900px;
    margin: 2rem auto;
    padding: 0 1rem;
  }
  .welcome {
    background-color: white;
    border-radius: 8px;
    padding: 2rem;
    box-shadow: 0 8px 20px rgba(0,0,0,0.1);
    margin-bottom: 2rem;
    text-align: center;
  }
  h2 {
    margin-top: 0;
    color: #2a3d66;
  }
  .stats {
    display: flex;
    justify-content: space-around;
    gap: 1rem;
    flex-wrap: wrap;
  }
  .stat-card {
    background: white;
    flex: 1 1 200px;
    border-radius: 8px;
    padding: 1.6rem;
    box-shadow: 0 5px 15px rgba(0,0,0,0.08);
    text-align: center;
  }
  .stat-card h3 {
    margin: 0.5rem 0;
    font-size: 2.4rem;
    color: #4a90e2;
  }
  .stat-card p {
    margin: 0;
    font-weight: 600;
    color: #555;
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
    <h1>Dashboard - Intranet Mailing System</h1>
  </header>
  <nav>
    <a href="dashboard.jsp" class="nav-link active">Dashboard</a>
    <a href="compose.jsp" class="list-group-item list-group-item-action">Compose</a>
    <a href="inbox" class="list-group-item list-group-item-action">Inbox</a>
    <a href="sent" class="list-group-item list-group-item-action">Sent</a>
    <a href="drafts" class="list-group-item list-group-item-action">Draft</a>
    <a href="login.jsp" style="margin-left:auto;">Logout</a>
  </nav>
  <main>
    <section class="welcome">
      <h2>Welcome, ${user.name}</h2>
      <p>Here's a quick overview of your mail activity.</p>
    </section>
    <section class="stats">
      <div class="stat-card">
        <p>Unread Messages</p>
        <h3 id="unreadCount">3</h3>
        <a href="inbox" class="list-group-item list-group-item-action">Inbox</a>
      </div>
      <div class="stat-card">
        <p>Sent Messages</p>
        <h3 id="sentCount">5</h3>
        <a href="sent" class="list-group-item list-group-item-action">Sent</a>
      </div>
      <div class="stat-card">
        <p>Draft Messages</p>
        <h3 id="draftCount">1</h3>
        <a href="drafts" class="list-group-item list-group-item-action">Draft</a>
      </div>
    </section>
  </main>
       <footer>
    &copy; 2025 Intranet Mailing System
  </footer>
</body>
</html>
