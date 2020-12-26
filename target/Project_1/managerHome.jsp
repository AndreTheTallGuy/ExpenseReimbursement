<jsp:include page ="header.jsp"/>

<div class="container mt-5 ">
<ul class="nav nav-tabs">
  <li class="nav-item">
    <p class="nav-link nav1 active" >Pending</p>
  </li>
  <li class="nav-item">
    <p class="nav-link nav2" >Resolved</p>
  </li>
  <li class="nav-item">
    <p class="nav-link nav3" >Employees</p>
  </li>
  <li class="nav-item">
    <p class="nav-link nav4" >Profile</p>
  </li>
  <li class="nav-item">
    <p class="nav-link log-out" >Log Out </p>
  </li>
</ul>
<div class="widget container" id="manager-main">
  <main class="main1 ">
    <h4 class="pt-4">Pending Reimbursements</h4>
    <div class="table-div">
      <table id="pending">
        <thead>
          <tr> 
            <th>Employee</th>
            <th>Amount</th> <th>Reason</th> 
          </tr>
        </thead>
      </table>
    </div>
    </main>

  <main class="main2 hide">
    <h4 class="pt-4">Resolved Reimbursements</h4>
    <table id="resolved">
      <thead>
        <tr> 
          <th>Employee</th>
          <th>Amount</th>
          <th>Reason</th>
          <th>Result</th>
          <!-- <th>Reviewed By</th>  -->
        </tr>
      </thead>
    </table>
  </main>

  <main class="main3 hide">
    <h4 class="pt-4">Employees</h4>
    <table id="employees">
      <thead>
        <tr> 
          <th>Employee</th>
          <th>Phone</th> <th>Username</th>
          <!-- <th>Reviewed By</th>  -->
        </tr>
      </thead>
    </table>
  </main>
  <main class="main4 hide profile">
    <h4 id="title" class="pt-4"></h4>
    <p id="fname"></p>
    <p id="lname"></p>
    <p id="phone"></p>
    <p id="email"></p>
    <p id="username"></p>
  </main>
</div>
</div>


<jsp:include page="footer.jsp"/>
