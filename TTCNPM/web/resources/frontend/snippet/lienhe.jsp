<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<div class="main-content">
    <div class="container">
        <div class="gioithieu">
            <div class="row">
                <div class="col-md-5"> 
                    <img class="img-responsive" src="<c:url value="/resources/frontend/snippet/images/cuahang.jpg" />" alt="">
                </div>
                <div class="col-md-7">
                    <h3>Giới thiệu </h3>
                    <p>Từ khi thành lập đến nay, <b>BKBook</b> luôn là Nhà sách trên mạng hàng đầu tại Việt Nam và được ghi nhận từ nhiều cơ quan, tổ chức trong và ngoài nước. Quan trọng hơn hết, <b>BKBook</b> được hàng triệu khách hàng thường xuyên mua sắm trực tuyến đặt sự tin tưởng và tín nhiệm của mình trong suốt hơn 10 năm qua để <b>BKBook</b> luôn được phục vụ và phát triển.</p>
                    <p>Với sứ mệnh xóa bỏ mọi giới hạn về không gian trong việc phân phối "tri thức" đến mọi miền đất nước bằng mô hình mua sắm trực tuyến hiện đại, từ miền núi đến hải đảo xa xôi, từ thành phố đến vùng quê và từ Việt Nam đến kiều bào ta ở trên toàn thế giới.</p>
                    <p>Mục tiêu của chúng tôi là luôn mở rộng thị trường sách trực tuyến cùng với đà phát triển của công nghệ thông tin. Để thực hiện mục tiêu đó, chúng tôi đã có những nhận thức đúng đắn về vai trò của nguồn nhân lực trong xây dựng và phát triển kinh doanh. Chúng tôi đã và đang không ngừng hoàn thiện hơn nữa môi trường làm việc với các trang thiết bị hiện đại, cung cách làm việc hiệu quả để ngày càng hoàn thiện việc phục vụ khách hàng.</p>
                </div>
            </div>
        </div>
        <hr>
        <div class="diachi">
            <div class="row">
                <div class="col-md-5">
                    <h3>Liên hệ</h3>
                    <p>Địa chỉ: 497 Hòa Hảo - Phường 7 - Quận 10 - TP Hồ Chí Minh</p>
                    <p>Điện thoại: (08)123456 - 097654321</p>
                    <p>Email: contact.bkbook@gmail.com</p>
                </div>
                <div class="col-md-7">
                    <section class="map">
                        <iframe width="100%" height="250px" frameborder="0" scrolling="no" marginheight="0" marginwidth="0" src="https://maps.google.com/maps?f=q&amp;source=s_q&amp;hl=en&amp;geocode=&amp;q=Ký+túc+xá+Đại+học+Bách+Khoa,+497,+Hòa+Hảo,+phường+7,+Quận+10,+Ho+Chi+Minh+City,+Vietnam&amp;sll=10.7601071,106.6599169&amp;sspn=0.128789,0.264187&amp;iwloc=A&amp;output=embed"></iframe>
                        <br />
                        <small>
                            <a href="https://maps.google.com/maps?f=q&amp;source=embed&amp;hl=en&amp;geocode=&amp;q=Ký+túc+xá+Đại+học+Bách+Khoa,+497,+Hòa+Hảo,+phường+7,+Quận+10,+Ho+Chi+Minh+City,+Vietnam&amp;sll=10.7601071,106.6599169&amp;sspn=0.128789,0.264187&amp;t=m&amp;z=15&amp;iwloc=A"></a>
                        </small>
                        </iframe>
                    </section>
                </div>
            </div>
        </div>
        <hr>
        <div class="gopy">
            <h3>Góp ý</h3>
            <form action="mailto:contact.bkbook@gmail.com" method="post">
                <div class="row">
                    <div class="col-md-6">
                        <div class="form-group">
                            <label for="exampleInputEmail1">Họ và tên</label>
                            <input type="text" class="form-control" id="exampleInputName" placeholder="Nguyễn Văn A">
                        </div>
                        <div class="form-group">
                            <label for="exampleInputEmail1">Số điện thoại</label>
                            <input type="text" class="form-control" id="exampleInputPhone" placeholder="0987654321">
                        </div>
                        <div class="form-group">
                            <label for="exampleInputEmail1">Email</label>
                            <input type="email" class="form-control" id="exampleInputEmail1" placeholder="nguyenvana@gmail.com">
                        </div>
                    </div>
                    <div class="col-md-6">
                        <br>
                        <textarea class="form-control" rows="6" placeholder="Góp ý của bạn..."></textarea><br>
                        <button type="submit" class="btn btn-primary goi">Gửi</button>
                    </div>
                </div>
            </form>
        </div>
    </div>
</div>