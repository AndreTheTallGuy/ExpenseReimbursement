<jsp:include page ="header.jsp"/>

<div class="container mt-5">
    <form action="/signup" method="POST">
        <div class="form-group">
            <label for="fname"> </label>
                <input type="text"  name="fname" placeholder="First Name"/>
    
        </div>
        <div class="form-group">
            <label for="lname"> </label>
                <input type="text"  name="lname" placeholder="Last Name"/>
    
        </div>
        <div class="form-group">
            <label for="email"> </label>
                <input type="email"  name="email" placeholder="Email"/>
    
        </div>
        <div class="form-group">
            <label for="phone"> </label>
                <input type="tel"  name="phone" placeholder="Phone"/>
    
        </div>
        <div class="form-group">
            <label for="username"></label>
                <input type="text"  name="username" placeholder="Username"/>

        </div>
        <div class="form-group">
            <label for="password"> </label>
                <input type="password"  name="password" placeholder="Password"/>

        </div>

    <button type="submit" id="submit" class="btn btn-success">Submit</button>
    </form>
</div>

<jsp:include page="footer.jsp"/>