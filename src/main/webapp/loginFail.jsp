<jsp:include page ="header.jsp"/>


<div class="container mt-5">
    <h5 id="fail">Invalid Credentials. Please try again. </h5>
    <form action="/home" method="POST" class="mt-2">
        <div class="form-group">
            <label for="username"></label>
                <input type="text"  name="username" placeholder="Username"/>

        </div>
        <div class="form-group">
            <label for="password"> </label>
                <input type="password"  name="password" placeholder="Password"/>

        </div>

        <button type="submit" id="submit" class="btn btn-success">Submit</button>
        <a href="/signUp.jsp" class="btn btn-success">Sign Up</a>
    </form>
</div>

<jsp:include page ="footer.jsp"/>