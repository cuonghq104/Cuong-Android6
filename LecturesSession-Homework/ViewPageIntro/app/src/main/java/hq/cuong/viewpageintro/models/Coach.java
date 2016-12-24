package hq.cuong.viewpageintro.models;

/**
 * Created by Cuong on 12/23/2016.
 */
public class Coach {

    private String imageUrl;

    private String name;

    private String bio;

    public Coach(String imageUrl, String name, String bio) {
        this.imageUrl = imageUrl;
        this.name = name;
        this.bio = bio;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    private static final Coach[] COACHES = new Coach[] {
            new Coach("adam_levine", "Adam Levine", "Adam Noah Levine sinh ngày 18 tháng 3, 1979 tại Los Angeles, California, Hoa Kỳ. Anh là một ca sĩ, nhạc công, nhạc sỹ người Mỹ, thường được biết đến là giọng hát chính và là thủ lĩnh của ban nhạc pop rock Maroon 5. Anh cũng là một giám khảo trong chương trình truyền hình The Voice cùng Christina Aguilera, Cee Lo Green, Usher, Shakira, Gwen Stefani, Pharrell Williams và Blake Shelton"),
            new Coach("gwen_stefani", "Gwen Stefani", "Gwen Renée Stefani (sinh ngày 3 tháng 10 năm 1969) là một ca sĩ, người viết bài hát, nhà thiết kế thời trang và đôi khi là nữ diễn viên người Mỹ. Stefani là người đồng sáng lập và là giọng ca chính cho ban nhạc rock-ska No Doubt. Stefani đã thu âm album phòng thu hát đơn đầu tay của mình mang tên Love. Angel. Music. Baby. vào năm 2004. Album mang ảnh hưởng của âm nhạc thập niên 1980 và đã đạt được thành công thương mại, với 7 triệu bản sao album được bán ra toàn thế giới. Đĩa đơn thứ ba từ Love. Angel. Music. Baby. mang tên \"Hollaback Girl\" là đĩa đơn phát hành dưới dạng tải nhạc số đầu tiên vượt mốc một triệu bản. Album phòng thu thứ hai và cuối cùng của Stefani mang tên The Sweet Escape được phát hành năm 2006. Tới nay, Stefani đã tiêu thụ được trên 40 triệu bản album toàn thế giới nếu cộng cả doanh số hát đơn của cô với doanh số của No Doubt."),
            new Coach("pharrell_williams", "Pharrell William", "Pharrell Williams hay còn được gọi là  Pharrell, sinh ngày 5 tháng 4 năm 1973, là một Ca sĩ, Nhạc sĩ, doanh nhân, nhà sản xuất, rapper, Nhà thiết kế thời trang người Mỹ.Williams cùng với Chad Hugo sáng lập The Neptune, sản xuất các sản phẩm âm nhạc soul, hiphop, R&B.Anh cũng là giọng ca chính kiêm tay trống của nhóm nhạc NERD, các thành viên còn lại của ban nhạc bao gồm Hugo và Shay Haley- người bạn từ thời thơ ấu của William.Năm 2003, Anh đã phát hành đĩa đơn đầu tiên của anh, \"Frontin\".Năm 2006, anh  cho phát hành  Album solo đầu tiên của anh, \"In My Mind\".Tháng 3 năm 2014, anh phát hành Album thứ 2, \"Girl\"."),
            new Coach("blake_shelton", "Blake Shelton", "Blake Tollison Shelton (sinh ngày 18 tháng 6, 1976, ở Ada, Oklahoma) là một ca sĩ nhạc đồng quê người Mỹ. Vợ anh là Miranda Lambert cũng là một ngôi sao khác của dòng nhạc đồng quê.")
    };

    public static Coach[] getCOACHES() {
        return COACHES;
    }
}
