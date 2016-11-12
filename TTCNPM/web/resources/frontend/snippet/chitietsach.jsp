<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="main-content">
    <section id="maincontent">
        <div class="container">
            <div class="row">
                <div>
                    <div class="panel panel-tittle">
                        <!-- Book detail body-->
                        <div class="panel-body">
                            <div class="row">
                                <div class="col-md-4">
                                    <div id="bookCover">
                                        <img height="400px" src="<c:url value="/resources/frontend/snippet/images/${book.image}" />" alt=""/>
                                    </div>
                                </div>

                                <div class="col-md-4">
                                    <div class="row">
                                        <label id="bookName" class="bookIntro" >${book.name}</label>
                                    </div>
                                    <div class="row">
                                        <label class="bookIntro">Tác giả : ${book.writer}</label>
                                        <label class="bookIntro">Nhà xuất bản : ${book.publisher} </label>
                                        <label class="bookIntro">Nhà phát hành : ${book.contributor} </label>
                                    </div>
                                    <div class="row">
                                        <div class="star"></div>
                                        <div class="star"></div>
                                        <div class="star"></div>
                                        <div class="star"></div>
                                        <div class="star"></div>
                                        <div class="clear"></div>
                                    </div>
                                    <div class="row">
                                        <button type="submit" class="btn btn-primary" id="like">Thích</button>
                                        <button type="submit" class="btn btn-primary ">Chia sẻ</button>
                                    </div>
                                </div>

                                <div class="col-md-4">
                                    <div class="col-md-12 cart-frame-detail">
                                        <div class="row">
                                            <label id="cartTittle" class="cartItem">Thông tin giá sách</label>
                                            <label class="cartItem">Giá trên bìa :  ${book.price} VND</label>
                                            <label class="cartItem">Giá bán sách : ${book.salePrice} VND</label>
                                            <label class="cartItem">Khoản tiết kiệm : ${book.savedPrice} VND</label>
                                        </div>
                                        <div class="row">
                                            <div id="cartIcon"></div>
                                            <a href="cart/addToCart?id=${book.id}" class="btn btn-primary insertCart">Thêm vào giỏ hàng</a>
                                        </div>
                                    </div>
                                </div>

                            </div>

                            <!--row2-->
                            <div class="row book-info-frame">
                                <div class="row">
                                    <div class="col-md-12">
                                        <label id="infoTittle" class="infoClass">Thông tin sách</label>
                                    </div>
                                </div>
                                <div class="row">
                                    <div class="col-md-5 col-md-offset-1">
                                        <label class="infoClass">Tác giả : ${book.writer}</label>
                                        <label class="infoClass">Nhà xuất bản : ${book.publisher}</label>
                                        <label class="infoClass">Ngôn ngữ : ${book.language}</label>
                                        <label class="infoClass">Kích thước : ${book.size}</label>
                                        <label class="infoClass">Số trang: ${book.page} trang</label>
                                    </div>
                                    <div class="col-md-5">
                                        <label class="infoClass">Nhà phát hành : ${book.contributor}</label>
                                        <label class="infoClass">Khối lượng: ${book.weight} (g)</label>
                                        <label class="infoClass">Định dạng : ${book.format}</label>
                                        <label class="infoClass">Ngày phát hành : ${book.publishDay}</label>
                                    </div>
                                </div>

                            </div>
                            <!--Comment-->
                            <div class="row comment-frame">
                                <label id="commentTittle">Bình luận:</label>
                                <label id="commentNum">1 bình luận</label>
                                <div class="row">
                                    <div class="col-md-2 col-md-offset-1">
                                        <div id="avatarComment"></div>
                                    </div>
                                    <div class="col-md-8">
                                        <div class="text-comment-frame">
                                            <textarea id="commentContent" rows="3" disabled="True">Phần comment sách nằm ở đây, hãy đưa ra ý kiến của bạn</textarea>
                                        </div>
                                    </div>
                                </div>
                                <div class="row">
                                    <div class="col-md-4 col-md-offset-3">
                                        <button type="submit" class="btn btn-link linkClick book-detail-link" id="reply_link">Trả lời</button>
                                        <button type="submit" class="btn btn-link linkClick" id="like_link">Thích</button>
                                    </div> 
                                </div>

                                <div class="row" id="under-reply">
                                    <div class="col-md-6 col-md-offset-3">
                                        <div class="text-comment-frame">
                                            <textarea id="replyContent" rows="2"></textarea>
                                        </div>
                                    </div>
                                    <div class="col-md-2">
                                        <button type="submit" class="btn btn-primary submit-comment" id="reply">Trả lời</button>
                                    </div>
                                </div>   


                                <div class="myComment col-md-10 col-md-offset-1">
                                    <label id="myComment-title">Bình luận của bạn</label>
                                    <div class="row">
                                        <div class="col-md-9 col-md-offset-2">
                                            <div class="text-comment-frame">
                                                <textarea id="replyContent" rows="4"></textarea>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="row">
                                        <div class="col-md-2 col-md-offset-9">
                                            <button type="submit" class="btn btn-primary submit-comment">Gửi</button>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <!--relative-->
                            <div class="row relative-frame">
                                <label id="relativeTittle">Sách bạn có thể quan tâm:</label>
                                <div class="row">
                                    <c:forEach var="relativeBook" items="${relativeBooks}">
                                        <a href="book/detail?id=${relativeBook.id}">
                                            <div class="col-md-3 col-sm-6">
                                                <div class="row">
                                                    <div class="relativeBook">
                                                        <img src="<c:url value="/resources/frontend/snippet/images/${relativeBook.image}" />" />
                                                    </div>
                                                </div>
                                                <div class="row">
                                                    <div class="cost-relative">
                                                        <label>${relativeBook.price} VND</label>
                                                    </div>
                                                </div>
                                            </div>
                                        </a>
                                    </c:forEach>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div> <!-- /.main row-->
        </div> <!-- /.container-->
    </section> <!-- /.main-->
</div>

<script>
    jQuery("#under-reply").hide();
    jQuery("#reply_link").click(function () {
        jQuery("#under-reply").toggle();
    });
</script>