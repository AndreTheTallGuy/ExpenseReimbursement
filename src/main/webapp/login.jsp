<jsp:include page ="header.jsp"/>


<div class="hero">
    <h2 class="title center">Paid Quik
</div>

<div class=" center"><h4 class="subtitle">Reimbursements</h4></div>

<div class="container mt-5">
    <form action="/home" method="POST">
    <div class="form-group">
        <label for="username"></label>
            <input type="text"  name="username" placeholder="Username"/>

    </div>
    <div class="form-group">
        <label for="password"> </label>
            <input type="password"  name="password" placeholder="Password"/>

    </div>

    <button type="submit" id="submit" class="btn btn-success">Submit</button>
    <a href="/signup" class="btn btn-success">Sign Up</a>
    </form>
    
</div>

<!-- <div class=" center">
    <img class="money" src="./images/money.png" alt="whole lot of cash">
</div> -->

<jsp:include page ="footer.jsp"/>