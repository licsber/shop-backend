package site.licsber.shop.service.impl;

import org.springframework.stereotype.Service;
import site.licsber.shop.model.Res;
import site.licsber.shop.model.entity.Comment;
import site.licsber.shop.model.entity.Item;
import site.licsber.shop.model.form.SubmitCommentForm;
import site.licsber.shop.repository.CommentRepository;
import site.licsber.shop.repository.ItemRepository;
import site.licsber.shop.service.SubmitCommentService;

import java.util.Optional;

@Service
public class SubmitCommentServiceImpl implements SubmitCommentService {

    final private ItemRepository itemRepository;
    final private CommentRepository commentRepository;

    public SubmitCommentServiceImpl(ItemRepository itemRepository,
                                    CommentRepository commentRepository) {
        this.itemRepository = itemRepository;
        this.commentRepository = commentRepository;
    }

    @Override
    public Res submitComment(SubmitCommentForm submitCommentForm) {
        Res res = new Res(400, "商品id不存在", null);
        Optional<Item> item = itemRepository.findById(submitCommentForm.getItemId());
        if (item.isPresent()) {
            Comment comment = Comment.builder()
                    .item(item.get())
                    .msg(submitCommentForm.getMsg())
                    .user(submitCommentForm.getUser())
                    .build();
            comment = commentRepository.save(comment);
            res.setCode(200);
            res.setMsg("添加评论成功");
            res.setData(comment.getId());
        }
        return res;
    }

}
