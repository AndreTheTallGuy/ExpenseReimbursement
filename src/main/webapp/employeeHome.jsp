<jsp:include page ="header.jsp"/>

<div class="container mt-5 ">
  <ul class="nav nav-tabs">
    <li class="nav-item">
      <p class="nav-link nav1 active" >Request</p>
    </li>
    <li class="nav-item">
      <p class="nav-link nav2" >Pending</p>
    </li>
    <li class="nav-item">
      <p class="nav-link nav3" >Resolved</p>
    </li>
    <li class="nav-item">
      <p class="nav-link nav4" >Profile</p>
    </li>
    <li class="nav-item">
      <p class="nav-link log-out" >Log Out</p>
    </li>
  </ul>
  <div class="widget container" id="employee-main">
    <main class="main1 ">
      <p class="pt-4">Create a new reimbursement request</p>
      <form action="/reimb" method="POST" class="mt-4">
        <div class="form-group">
            <label for="amount"> </label>
                <input type="text" min="0.01" step="0.01" max="2500" id="amount" name="amount" placeholder="Amount"/>
        </div>
        <div class="form-group">
            <label for="Reason"> </label>
                <textarea rows="5" cols="33"  name="reason" placeholder="Reason for request"></textarea>
        </div>
        <button type="submit" class="btn btn-success">Submit</button>
      </form>
    </main>
    <main class="main2 hide">
      <h4 class="pt-4">Pending Reimbursements</h4>
      <table id="pending-id">
        <thead>
          <tr> <th>Amount</th> <th>Reason</th> </tr>
        </thead>     
      </table>
    </main>
    <main class="main3 hide">
      <h4 class="pt-4">Resolved Reimbursements</h4>
      <table id="resolved-id">
        <thead>
          <tr> 
            
            <th>Amount</th> <th>Reason</th>
            <th>Result</th>
            <!-- <th>Reviewed By</th>  -->
          </tr>
        </thead>
      </table>
    </main>
    <main class="main4 hide">
      <h4 id="title" class="pt-4"></h4>
    <p id="fname"></p>
    <p id="lname"></p>
    <p id="phone"></p>
    <p id="email"></p>
    <p id="username"></p>
    </main>
  </div>
  </div>

  <jsp:include page= "footer.jsp"/>