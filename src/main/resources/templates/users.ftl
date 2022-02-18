<#import "parts/layout.ftl" as layout>
<@layout.page>
    <div class="page-body">
        <div class="container-fluid">
            <div class="page-header">
                <div class="row">
                    <div class="col-lg-6 main-header">
                        <h2 style="color: black">Basic <span>DataTables  </span></h2>
                        <h6 style="color: black" class="mb-0">admin panel</h6>
                    </div>
                    <div class="col-lg-6 breadcrumb-right">
                        <ol class="breadcrumb">
                            <li style="color: black" class="breadcrumb-item"><a href="/"><i class="pe-7s-home"></i></a></li>
                            <li style="color: black" class="breadcrumb-item">Friends</li>
                        </ol>
                    </div>
                </div>
            </div>
        </div>
        <!-- Container-fluid starts-->
        <div class="container-fluid">
            <div class="row">
                <div class="col-sm-12">
                    <div class="card">
                        <div class="card-header">
                            <h5 style="color: black">Friends list</h5>
                        </div>
                        <div class="card-body">
                            <div class="table-responsive">
                                <table class="display" id="basic-2">
                                    <thead>
                                    <tr>
                                        <th style="color: black">Name</th>
                                        <th style="color: black">Account created date</th>
                                    </tr>
                                    </thead>
                                    <tbody>
                                    <#list friends as friend>
                                        <tr>
                                            <td style="color: black"><a href="/user/${friend.getUsername()}">${friend.getUsername()}</a></td>
                                            <td style="color: black">${friend.getCreatedDate()}</td>
                                        </tr>
                                    </#list>
                                    </tbody>
                                </table>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</@layout.page>