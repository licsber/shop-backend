package site.licsber.shop.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import site.licsber.shop.dto.CommentDTO;
import site.licsber.shop.model.Res;
import site.licsber.shop.model.entity.Comment;
import site.licsber.shop.model.entity.Item;
import site.licsber.shop.repository.CommentRepository;
import site.licsber.shop.repository.ItemRepository;
import site.licsber.shop.service.GetCommentsService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class GetCommentsServiceImpl implements GetCommentsService {

    final private ItemRepository itemRepository;
    final private CommentRepository commentRepository;

    public GetCommentsServiceImpl(ItemRepository itemRepository, CommentRepository commentRepository) {
        this.itemRepository = itemRepository;
        this.commentRepository = commentRepository;
    }

    @Override
    public Res getComments(Integer itemId) {
        Res res = new Res(400, "获取评论失败", null);
        Optional<Item> item = itemRepository.findById(itemId);
        if (item.isEmpty()) {
            res.setMsg("商品编号不存在");
        } else {
            Iterable<Comment> comments = commentRepository.findAllByItem(item.get());
            List<CommentDTO> commentDTOS = new ArrayList<>();
            for (Comment comment : comments) {
                CommentDTO dto = new CommentDTO();
                BeanUtils.copyProperties(comment, dto);
                dto.setUserNick(comment.getUser().getNick());
                commentDTOS.add(dto);
            }
            res.setCode(200);
            res.setMsg("查询评论成功");
            res.setData(commentDTOS);
        }
        return res;
    }

}
